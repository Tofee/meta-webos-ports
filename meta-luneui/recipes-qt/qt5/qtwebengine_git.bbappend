FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "luna-service2 pmloglib qtlocation"

# Enable extra codecs
EXTRA_QMAKEVARS_PRE += "WEBENGINE_CONFIG+=use_proprietary_codecs"
EXTRA_QMAKEVARS_PRE += "GYP_CONFIG+=use_pulseaudio"
EXTRA_QMAKEVARS_PRE += "GYP_CONFIG+=enable_plugins=1"

SRC_URI += " \
    file://0001-Add-PalmSystemBridge-feature.patch \
    file://0002-WebEngineView-provide-additionnal-features-from-wind.patch \
    file://0003-WebEngineNewViewRequest-provide-the-requested-URL-as.patch \
    file://0004-Implement-Sync-IPC-messaging-through-qt.webChannelTr.patch \
    file://0005-Make-properties-for-some-settings-for-PalmBridgeServ.patch \
    file://0006-Revert-Fully-qualify-libEGL.so.1-libEGLESv2.so.2-lib.patch \
    file://0007-WebEngineSettings-Add-a-standardFontFamily-property-.patch \
    file://0008-WebEngineSettings-add-also-Serif-Fixed-and-Cursive-f.patch \
    file://0009-Store-the-additional-window-features-required-by-the.patch \
    file://0010-QQuickWebEngineNewViewRequest-use-initialTargetUrl-f.patch \
    file://0011-WebEngineNewViewRequest-add-possibility-to-get-reque.patch \
    file://0012-GetScreenInfo-use-default-screen-when-no-window-is-a.patch \
    file://0013-Enable-password-echo.patch \
    file://0014-Implement-RequestQuotePermission.patch \
    file://chromium/0001-qtwebengine-add-missing-include.patch;patchdir=./src/3rdparty \
    file://chromium/0002-html.css-themeWin.css-Add-Prelude-as-default-font-in.patch;patchdir=./src/3rdparty \
    file://chromium/0003-storage-browser-quota-workaround-for-crash-on-cache-.patch;patchdir=./src/3rdparty \
    file://chromium/0004-Enable-password-echo.patch;patchdir=./src/3rdparty \
    file://chromium/0005-WindowFeatures-Chrome-lower-the-minimum-height-to-5.patch;patchdir=./src/3rdparty \
    file://chromium/0006-WebContents-provide-additional-features-from-window..patch;patchdir=./src/3rdparty \
    file://chromium/0007-Fix-JSON-additional-window-features-parsing.patch;patchdir=./src/3rdparty \
    file://chromium/0008-Store-the-additional-window-features-related-to-Lune.patch;patchdir=./src/3rdparty \
    file://chromium/0009-Add-PalmServiceBridge-to-WebEngine.patch;patchdir=./src/3rdparty \
    "
