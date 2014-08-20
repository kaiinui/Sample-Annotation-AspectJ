Sample-Annotation-AspectJ
=========================

A sample of @annotation and AspectJ.

@PotatoTip annoteted methods will show the toast "POTATOTIP!" before performing the method.

![](https://dl.dropboxusercontent.com/u/7817937/_github/potatotip.gif)

Code?
---

```java
// MainActivity.java

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        doNothing();
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

