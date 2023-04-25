# android-plugin

### 第一步
```
  classpath "com.github.cqray:android-plugin:laset-version"
```
### 第二步
在App模块build.gradle中
```
apply plugin: 'com.android.plugin'
```
### 第三步

编译配置，只能在App模块使用。启用了会在每个模块加入相应的编译的依赖。
```
open class CompilerOptions {

    /** 是否启用快速布局 **/
    var butterKnifeEnabled = false

    /** 常用框架 **/
    var componentEnabled = false

    /** 是否启用Lombok **/
    var lombokEnabled = false

    /** 是否启用组件化框架 **/
    var serviceEnabled = false

}
```

模块配置，启用了会导入相关依赖
```
open class ModuleOptions {

    /** 是否启用快速布局 **/
    var butterKnifeEnabled = false

    /** 是否启用协程 **/
    var coroutineEnabled = false

    /** 是否启用Lombok **/
    var lombokEnabled = false

    /** 常用框架 **/
    var componentEnabled = false

    /** 是否启用组件化框架 **/
    var serviceEnabled = false

    /** 是否启用Retrofit网络请求 **/
    var retrofitEnabled = false

    /** 是否启用Room数据库 **/
    var roomEnabled = false

    /** 是否启用Rxjava2 **/
    var rxjava2Enabled = false

    /** 是否启用Rxjava3 **/
    var rxjava3Enabled = false

}
```
