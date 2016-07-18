package javacommon.exception;

/**
 * Action层定义的异常
 * @author： wangwch  mailto： <a href="wfun@163.com">wfun@163.com</a>
 * @since 1.1
 */
public class ActionException extends BaseRuntimeException {

	public ActionException() {
		super();
	}

	public ActionException(String message, Throwable cause) {
		super("Action层异常: " + message, cause);
	}

	public ActionException(String message) {
		super("Action层异常: " + message);
	}

	public ActionException(Throwable cause) {
		super(cause);
	}

}
