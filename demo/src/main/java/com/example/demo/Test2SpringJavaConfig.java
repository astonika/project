package com.example.demo;

public class Test2SpringJavaConfig {
//    private static final Logger logger = LoggerFactory.getLogger(Test2SpringJavaConfig.class);
//    private String DEFAULT_VALUE = "undefined";
//    private Config config;
//
//    public SimpleApolloConfigDemo() {
//        ConfigChangeListener changeListener = new ConfigChangeListener() {
//            @Override
//            public void onChange(ConfigChangeEvent changeEvent) {
//                logger.info("Changes for namespace {}", changeEvent.getNamespace());
//                for (String key : changeEvent.changedKeys()) {
//                    ConfigChange change = changeEvent.getChange(key);
//                    logger.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}", change.getPropertyName(), change.getOldValue(), change.getNewValue(),
//                            change.getChangeType());
//                }
//            }
//        };
//        config = ConfigService.getAppConfig();
//        config.addChangeListener(changeListener);
//    }
//
//    private String getConfig(String key) {
//        String result = config.getProperty(key, DEFAULT_VALUE);
//        logger.info(String.format("Loading key : %s with value: %s", key, result));
//        return result;
//    }
//
//    public static void main(String[] args) throws IOException {
//        Test2SpringJavaConfig apolloConfigDemo = new Test2SpringJavaConfig();
//        System.out.println("Apollo Config Demo. Please input key to get the value. Input quit to exit.");
//        while (true) {
//            System.out.print("> ");
//            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
//            if (input == null || input.length() == 0) {
//                continue;
//            }
//            input = input.trim();
//            if (input.equalsIgnoreCase("quit")) {
//                System.exit(0);
//            }
//            apolloConfigDemo.getConfig(input);
//        }
//    }
}