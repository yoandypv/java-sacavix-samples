package com.sacavix.concurrency.SampleInheritableWithExecutor;

public class AppContext {

        private static final InheritableThreadLocal<AppInfo> handler = new InheritableThreadLocal<>();

        public static void set(AppInfo info) {
            handler.set(info);
        }

        public static AppInfo get() {
            return handler.get();
        }

        public static void remove() {
            handler.remove();
        }
}
