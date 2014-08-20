// Generated code from Butter Knife. Do not modify!
package com.kaiinui.potatoannotation;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MyActivity$$ViewInjector {
  public static void inject(Finder finder, final com.kaiinui.potatoannotation.MyActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230721, "method 'onButtonClick'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onButtonClick();
        }
      });
  }

  public static void reset(com.kaiinui.potatoannotation.MyActivity target) {
  }
}
