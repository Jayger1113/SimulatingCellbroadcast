# testcellbroadcast
# git push origin HEAD
tutorial:
1. This app only valid build in system app through linux build, cause "android.permission.BROADCAST_SMS"
only permit by system permission, so we need to pretend we are system app.
2. clone source into your android source code into packages/app/
3. run the pre build env script: source build/envsetup.sh
4. make -j8 TestCellBroadcast
5. find the output apk
6. push into device
7. EX: 
- adb root
- adb remount
- adb shell mkdir system/priv-app/TestCellBroadcast
- adb push out/target/product/bullhead/system/priv-app/TestCellBroadcast/TestCellBroadcast.apk system/priv-app/TestCellBroadcast/

