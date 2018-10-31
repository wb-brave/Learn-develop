package thinkinjava.chapter19.enums.autosentmachine;


import thinkinjava.chapter18.util.TextFile;
import util.Generator;

import java.util.EnumMap;
import java.util.Iterator;

import static thinkinjava.chapter19.enums.autosentmachine.Input.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.autosentmachine
 * @email wubin326@qq.com
 * @date 2018/10/25
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/25        wubin            0.0.1
 */
public class VendingMachine {

    /**
     * 不能通过对象直接调用static成员
     * eq：VendingMachine vm = new VendingMachine(); vm.amount;(调用不到)
     */
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {
        TRANSIENT;
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
        }
        state.output();
    }

    public static void main(String[] args) {
        Generator<Input> generator = new RandomInputGenerator();
        if (args.length == 1) {
            generator = new FileInputGenerator();
        } else {
            run(generator);
        }
    }

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next(Input input) {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next(Input input) {
                if (amount > 0) {
                    System.out.println("your change " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("halted");
            }
        };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration sd) {
            this.isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("only call " + input + " next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("only call next() for " + "stateDuration.TRANSINEN states");
        }

        void output() {
            System.out.println(amount);
        }
    }
}

class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input> {

    private Iterator<String> input;

    public FileInputGenerator() {
    }

    public FileInputGenerator(String filename) {
        this.input = new TextFile(filename, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        } else {
            /**
             * 获取一个枚举类的指定枚举值
             */
            return Enum.valueOf(Input.class, input.next().trim());
        }
    }
}

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] inputs;

    Category(Input... inputs) {
        this.inputs = inputs;
    }

    public static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input input : category.inputs) {
                categories.put(input, category);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
