package thinkinjava.chapter19.enums.chainofresponsibility;

import thinkinjava.chapter19.enums.util.Enums;

import java.util.Iterator;
import java.util.logging.Handler;

/**
 * @author wubin
 * @Description 使用职责链模式来简单模拟邮局，其中也涉及到了策略模式
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.chainofresponsibility
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SACN {
            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                switch (mail.readability) {
                    case UNREADABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        },
        DELIEVERY_OTHER {
            @Override
            boolean handle(Mail mail) {
                switch (mail.address) {
                    case INCORRECT:
                        return false;
                    default:
                        System.out.println("Delivering " + mail + " to other");
                        return true;
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender!");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail m) {
        /**
         * 记录处理的结果为false的次数
         * 如果4次全部不通过，判定为废弃的信
         */
        int count = 0;
        for (MailHandler mailHandler : MailHandler.values()) {
            if (!mailHandler.handle(m))
                count++;
        }
        if (count == 4) {
            System.out.println("mail: " + m + " is dead letter！");
        }
    }

    public static void main(String[] args) {

        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("********************");
        }


    }
}

class Mail {
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {
        UNSCANNABLE, YES1, YES2, YES3, YES4
    }

    enum Readability {
        UNREADABLE, YES1, YES2, YES3, YES4
    }

    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
    }

    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() +
                " : generalDelivery=" + generalDelivery +
                ", scannability=" + scannability +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress +
                '}';
    }

    // generate test mail
    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
