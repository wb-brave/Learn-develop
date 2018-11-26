package thinkinjava.chapter10.innerclass;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class Parcel1 {

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.contents();
        Destination wubin = parcel.destination("wubin");
        Parcel.PDestination haode = parcel.new PDestination("haode");
    }
}

class Parcel {
    private class PContents implements Contents {
        @Override
        public int value() {
            return 10;
        }
    }

    protected class PDestination implements Destination {

        private String lable;

        public PDestination(String lable) {
            this.lable = lable;
        }

        @Override
        public String readLable() {
            return lable;
        }
    }

    public Destination destination(String lable) {
        return new PDestination(lable);
    }

    public Contents contents() {
        return new PContents();
    }

}
