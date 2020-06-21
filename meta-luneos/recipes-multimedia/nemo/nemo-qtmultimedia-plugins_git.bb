SUMMARY = "Nemo mobile QtMultimedia plugin for rendering"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qtmultimedia-plugins/tree/master"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/videotexturebackend/videotexturebackend.cpp;beginline=5;endline=30;md5=d94b18e09e6203f746ef7a341d95fe84"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qtmultimedia-plugins.git;protocol=https \
	   file://0001-Fix-Qt-5.15-build.patch \
"

#SRCREV = "6c7a63379e52691725b82e41b303420ecb76dd30"
#PV = "20200421+git${SRCPV}"

SRCREV = "d63c62e35c542693ac1c8b39c4a35448e7d47505"
PV = "20200220+git${SRCPV}"

S = "${WORKDIR}/git"
DEPENDS += "qtbase qtmultimedia gstreamer1.0 nemo-gst-interfaces"

inherit qmake5

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}"
