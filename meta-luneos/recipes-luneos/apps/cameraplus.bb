SUMMARY = "Cameraplus application"
SECTION = "webos/apps"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=4fbd65380cdd255951079008b364516c \
"

PV = "0.0.2-1+git${SRCPV}"
SRCREV = "58a6b5c41e890b9298285fba5a5137b3848b8bc3"

DEPENDS = "qtbase qtdeclarative qtmultimedia qtsystems qtsensors qttools-native tiff nemo-gst-interfaces pulseaudio"

SRC_URI = "git://github.com/Tofee/cameraplus.git;branch=luneos"
S = "${WORKDIR}/git"

inherit pkgconfig
inherit webos_application
inherit webos_filesystem_paths

inherit cmake_qt5
inherit webos_cmake

INSANE_SKIP_${PN} += "libdir"
INSANE_SKIP_${PN}-dbg = "libdir"

EXTRA_OECMAKE += "-DPLATFORM:STRING='luneos' -DDATA_DIR=${webos_applicationsdir}/cameraplus/qtcamera/config/"

FILES_${PN} += "${webos_applicationsdir}/cameraplus"

RDEPENDS_${PN} = " \
    qtdeclarative-qmlplugins \
"

do_install_append() {
    # qtcamera configuration
    install -d ${D}${webos_applicationsdir}/cameraplus/qtcamera/config
    
    install -m 0644 ${S}/data/sailfish/device.ini ${D}${webos_applicationsdir}/cameraplus/qtcamera/config/device.ini
    install -m 0644 ${S}/data/sailfish/qtcamera.ini ${D}${webos_applicationsdir}/cameraplus/qtcamera/config/qtcamera.ini
    install -m 0644 ${S}/data/sailfish/video.gep ${D}${webos_applicationsdir}/cameraplus/qtcamera/config/video.gep
    install -m 0644 ${S}/data/sailfish/image.gep ${D}${webos_applicationsdir}/cameraplus/qtcamera/config/image.gep
    install -m 0644 ${S}/data/sailfish/properties.ini ${D}${webos_applicationsdir}/cameraplus/qtcamera/config/properties.ini

    # cameraplus configuration
    install -d ${D}${webos_applicationsdir}/cameraplus/config
    install -m 0644 ${S}/data/sailfish/cameraplus.ini ${D}${webos_applicationsdir}/cameraplus/config/cameraplus.ini
    install -m 0644 ${S}/data/sailfish/features.ini ${D}${webos_applicationsdir}/cameraplus/config/features.ini

    # cameraplus "plugins"
    install -d ${D}${webos_applicationsdir}/cameraplus/modes
    for mode in fast-capture.ini image.ini image-panorama.ini image-sequential.ini image-timer.ini video.ini; do
        install -m 0644 ${S}/modes/${mode} ${D}${webos_applicationsdir}/cameraplus/modes/${mode}
    done
}
