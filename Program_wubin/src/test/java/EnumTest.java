public enum EnumTest{
    //枚举这个类的构造 使用前必须先定义构造函数
    RED("red",1),GREEN("GREEN",2);
    private String values;
    private int type;
    EnumTest(String values,int type){
        this.values = values;
        this.type = type;
    }

    public static String getColor(int type){
        for (EnumTest e: EnumTest.values()
             ) {
            if (type == e.getType()){
                return e.getValues();
            }
        }
        return null;
    }
    public void setValues(String values) {
        this.values = values;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getValues() {
        return values;
    }
}
