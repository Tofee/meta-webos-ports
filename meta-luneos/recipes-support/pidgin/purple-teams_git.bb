SUMMARY = "Teams protocol plug-in for libpurple"
SECTION = "webos/services"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=30441c91ba0022ea994b5dae832bd063"

DEPENDS = "pidgin json-glib glib-2.0"

inherit pkgconfig

SRC_URI = "git://github.com/EionRobb/purple-teams;branch=master;protocol=https"
SRCREV = "012c3d05bc88146487f833e1805293fcde664449"

S = "${WORKDIR}/git"
PV = "0.1.0+git"

do_compile() {
    oe_runmake CC="${CC}";
}

do_install() {
    oe_runmake CC="${CC}" DESTDIR="${D}" install;
}

FILES:${PN} += " \
    ${libdir} \
"
