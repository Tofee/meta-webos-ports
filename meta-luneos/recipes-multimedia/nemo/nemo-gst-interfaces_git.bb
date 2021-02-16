SUMMARY = "Nemo mobile specific GStreamer interfaces"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-gst-interfaces/tree/master"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.sailfishos.org/mer-core/nemo-gst-interfaces.git;protocol=https"

SRCREV = "c1deaea7b52bbd12cea56c4ada69eba17cb602a8"
PV = "20200911+git${SRCPV}"

S = "${WORKDIR}/git"
DEPENDS += "gstreamer1.0-plugins-base"

inherit autotools pkgconfig
