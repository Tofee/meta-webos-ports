SUMMARY = "Advanced Camera application"
SECTION = "webos/apps"
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

PV = "0.6.6-1+git${SRCPV}"
SRCREV = "e3e7d24677508bb7f84510577c55e74854be388b"

DEPENDS = "qtbase qtdeclarative qtmultimedia qttools-native"

SRC_URI = "git://github.com/Tofee/harbour-advanced-camera.git;branch=luneos"
S = "${WORKDIR}/git"

inherit pkgconfig
inherit webos_application
inherit webos_filesystem_paths

inherit qmake5

APP_PATH = "${webos_applicationsdir}/${PN}"
EXTRA_QMAKEVARS_PRE = "\
    DEPLOYMENT_PATH=${APP_PATH} \
"

FILES_${PN} += "${APP_PATH}"

RDEPENDS_${PN} = " \
    qtdeclarative-qmlplugins \
"
