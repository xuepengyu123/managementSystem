

package com.sys.manage.annotation;

import java.lang.annotation.*;

/**
 * 登录效验
 *
 * @author xue
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
