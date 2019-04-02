package thinkinjava.chapter20.annotations.database;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations.database
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
@DBTable(name = "member")
public class Member {

    @SQLString(30)
    String firstname;
    @SQLString(60)
    String lastname;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, CONSTRAINTS = @Constraints(privateKey = true,canNull = false))
    String handle;
    static int memberCount;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
