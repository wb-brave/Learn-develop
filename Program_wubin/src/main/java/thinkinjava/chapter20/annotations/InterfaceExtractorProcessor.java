package thinkinjava.chapter20.annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author wubin
 * @Description exec apt -factory thinkinjava.chapter20.annotations.InterfaceExtractorProcessorFactory thinkinjava.chapter20.annotations.Multiplier.java -s thinkinjava.chapter20./annotations
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1  
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor {

    private final AnnotationProcessorEnvironment ape;

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment ape) {
        this.ape = ape;
    }

    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<>();

    @Override
    public void process() {
        for (TypeDeclaration typeDeclaration : ape.getSpecifiedTypeDeclarations()) {
            ExtractInterface annotation = typeDeclaration.getAnnotation(ExtractInterface.class);
            if (Objects.isNull(annotation)) {
                break;
            }
            /**
             * 获取public非static的方法存入list中
             */
            for (MethodDeclaration methodDeclaration : typeDeclaration.getMethods()) {
                if (methodDeclaration.getModifiers().contains(Modifier.PUBLIC) &&
                        !(methodDeclaration.getModifiers().contains(Modifier.STATIC))) {
                    interfaceMethods.add(methodDeclaration);
                }
            }
            if (interfaceMethods.size() > 0) {
                PrintWriter sourceFile = null;
                try {
                    sourceFile = ape.getFiler().createSourceFile(annotation.value());
                    sourceFile.println("package " + typeDeclaration.getPackage().getQualifiedName() + ";");
                    sourceFile.println("public interface " + annotation.value() + " {");
                    for (MethodDeclaration method : interfaceMethods) {

                        sourceFile.print("public " + method.getReturnType() + " " + method.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration param : method.getParameters()) {
                            sourceFile.print(param.getType() + " " + param.getSimpleName());
                            if (++i < method.getParameters().size()) {
                                sourceFile.print(", ");
                            }
                        }
                        sourceFile.println(") }");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    sourceFile.close();
                }
            }

        }

    }
}
