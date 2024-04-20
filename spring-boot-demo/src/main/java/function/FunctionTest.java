package function;

import cn.hutool.core.io.LineHandler;
import jdk.nashorn.internal.ir.IfNode;
import org.aopalliance.intercept.MethodInterceptor;

public class FunctionTest {
    public static void main(String[] args) {
        boolean flag = true;


        LineHandler lineHandler = t -> {
            if (flag) {
                System.out.println("111");
                System.out.println(t);
            }
        };

        lineHandler.handle("222");
    }
}
