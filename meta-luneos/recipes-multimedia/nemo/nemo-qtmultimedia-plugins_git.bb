SUMMARY = "Nemo mobile QtMultimedia plugin for rendering"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qtmultimedia-plugins/tree/master"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/videotexturebackend/videotexturebackend.cpp;beginline=5;endline=30;md5=d94b18e09e6203f746ef7a341d95fe84"

SRC_URI = "git://git.sailfishos.org/mer-core/nemo-qtmultimedia-plugins.git;protocol=https \
	   file://0001-Fix-Qt-5.15-build.patch \
"

SRCREV = "e1a70a56fced9f268b8f84c1af5691d9aefa585d"
PV = "20200914+git${SRCPV}"

S = "${WORKDIR}/git"
DEPENDS += "qtbase qtmultimedia gstreamer1.0 nemo-gst-interfaces"

inherit qmake5

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}"
