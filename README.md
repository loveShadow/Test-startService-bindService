# Test-startService-bindService
测试Service的两种方式（startService）

1、Service onBindService 和 startService 启动的区别（启动Service的两种方式）

     一、Service的生命周期很短，只有（onCreate --> onStart --> onDestroy）

     二、使用startService 启动服务，Service会分别调用（onCreate --> onStart）

               在此之后还可以调用bindService，Service会调用（onBind），调用之后通过stopService来关闭服务不能立马关掉，要调用unbindService，Service会调用（onUnbind --> onDestory）。

               startService可以多次调用，service不存在时会创建

     三、使用bindService 启动服务，Service会分别调用（onCreate --> onBind），之后调用startService来启动Service，同2.2 stopService也不能立马关掉Service，

     四、bindService的含义及与调用者绑定在一次，共存亡。调用者退出了，Service也就unbindService --> destroy退出了。


----------

	startService    1
	bindService     2
	unbindService   3
	stopService     4
	activity-finish 5

实验：

	15      onCreate -- onStart(服务未停止)
	25      onCreate -- onBind -- onUnbind -- onDestroy(服务未开启)
	125     onCreate -- onStart -- onBind -- onUnbind(服务未停止)
	215     onCreate -- onBind -- onStart -- onUnbind(服务未停止)
	1235    onCreate -- onBind -- onStart -- onUnbind(服务未停止)
	1245    onCreate -- onStart -- onBind -- (调用stopService不会立马停止，有绑定者在) -- onUnbind -- onDestroy(服务停止)
	2135    onCreate -- onBind -- onStart -- onUnbind(服务未停止)
	2145    onCreate -- onStart -- onBind -- (调用stopService不会立马停止，有绑定者在) -- onUnbind -- onDestroy(服务停止)

总结：

	1. 调用startService，必须调用stopService，才会触发onDestroy(15/)

	2. 调用startService不调用bindService，如果Activity退出不调用stopService，服务不会停止(15)

	3. 调用startService且调用bindService，如果Activity退出不调用stopService，服务不会停止（1235/2135）
