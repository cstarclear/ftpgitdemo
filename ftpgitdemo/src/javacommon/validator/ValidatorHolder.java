package javacommon.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用于持有Spring Validator,使调用Validator可以当静态方法使用.
 * 
 * <pre>
 * static 方法调用:
 * ValidatorHolder.validate(object);
 * </pre>
 * <pre>
 * </pre> 
 * @author wangwch
 *
 */
public class ValidatorHolder implements DisposableBean {

	private static Validator validator;

	@Autowired
	public void setValidator(Validator validator) {
		ValidatorHolder.validator = validator;
	}

	public static Validator getValidator() {
		assertValidatorInjected();
		return validator;
	}

	/**
	 * 调用JSR303的validate方法, 验证失败时返回ConstraintViolation组成的Set.
	 */
	public static <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
		assertValidatorInjected();
		return getValidator().validate(object, groups);
	}

	/**
	 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
	 */
	public static void validateWithException(Object object, Class<?>... groups) throws ConstraintViolationException {
		Set constraintViolations = validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	/**
	 * 清除Holder中的validator为null.
	 */
	public static void clearHolder() {
		validator = null;
	}

	@Override
	public void destroy() throws Exception {
		ValidatorHolder.clearHolder();

	}

	private static void assertValidatorInjected() {

		if (validator == null) {
			throw new IllegalStateException("Validator属性未注入.");
		}
	}
}
