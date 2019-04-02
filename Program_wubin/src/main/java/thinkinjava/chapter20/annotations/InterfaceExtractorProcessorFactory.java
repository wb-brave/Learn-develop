package thinkinjava.chapter20.annotations;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.tools.doclint.Env;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory{
    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    /**
     * 约束支持的注解类
     * @return
     */
    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("thinkinjava.chapter20.annotations.ExtractInterface");
    }

    /**
     * 构造一个注解处理类
     * 调用其process方法
     * @param set
     * @param annotationProcessorEnvironment
     * @return
     */
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new InterfaceExtractorProcessor(annotationProcessorEnvironment);
    }
}
