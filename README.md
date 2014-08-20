Sample-Annotation-AspectJ
=========================

A sample of @annotation and AspectJ.

@PotatoTip annoteted methods will show the toast "POTATOTIP!" before performing the method.

![](https://dl.dropboxusercontent.com/u/7817937/_github/potatotip.gif)

Code?
---

```java
// MyActivity.java

public class MyActivity extends Activity {
    @OnClick(R.id.button)
    public void onButtonClick() {
        doNothing(); // DO NOTHING BUT SHOW A TOAST
    }

    @PotatoTip
    public void doNothing() { // DO NOTHING BUT IT WILL SHOW A TOAST
    }
..
```

```java
// PotatoTip.java

@Target(METHOD)
@Retention(CLASS)
public @interface PotatoTip {}
```

```java
// PotatoAspect.java

@Aspect
public class PotatoAspect {
    @Pointcut("execution(@com.kaiinui.potatoannotation.PotatoTip * *(..))")
    public void method() {}

    @Around("method()")
    public Object executePotato(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        final Activity activity = (Activity) joinPoint.getThis();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "POTATOTIP!", Toast.LENGTH_SHORT).show();
            }
        });

        return result;
    }
}
```

References
---

- https://github.com/JakeWharton/hugo
- https://github.com/uPhyca/gradle-android-aspectj-plugin
