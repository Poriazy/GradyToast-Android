[![](https://jitpack.io/v/Poriazy/GradyToast-Android.svg)](https://jitpack.io/#Poriazy/GradyToast-Android)

# GradyToast-Android

<div align="center">
	<img src="https://poriazed.com/grady-toast/logo.png" width="128">
</div>

Toast with gradients.

## 🛠 Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## 🛠 Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	...
	implementation 'com.github.Poriazy:GradyToast-Android:1.0'
}
```


## 📱 Screenshots

**enlarge photo by click on it.**

<div align="center">
	<img src="https://poriazed.com/grady-toast/grady.jpg" width="512">
	<br>
	<img src="https://poriazed.com/grady-toast/collage.jpg">
</div>


## 🤔 How to use

Create Object of GradyToast:
```java

GradyToast gradyToast = new GradyToast(yourContext);

// or
GradyToast gradyToast = new GradyToast();
gradyToast.with(yourContext);

// or use the other constructors

```


## 🎨 Types

You Can use GradyToast with these types:


``` java

public enum GradyType {
    PRIMARY,
    SUCCESS,
    ERROR,
    WARNING,
    INFO,
    LIGHT,
    DARK,
    CUSTOM,
}

```

You can also create your custom Toasts with the `.setType(GradyType.CUSTOM)`,method:

``` java
GradyToast myCustomGrady = new GradyToast();
myCustomGrady
	.with(yourContext)
	.setText("Your Toast Message")
	.setDuration(GradyDuration.LONG)
	.setType(GradyType.CUSTOM)
	.setTextColor("#bdc3c7")
	.setCustomColors("#FF0099", "#493240", "#000000" )
	.setGradyStrokeSize(3)
	.show();
```

## ℹ Info & Simple usage:

``` java
GradyToast simpleGrady = new GradyToast(yourContext);
simpleGrady.setText("Hello World!");
/*
 * Defaults:
 *		tostDuration -> GradyDuration.SHORT 
 *		tostSyle -> GradyType.PRIMARY
 *
 */
```
