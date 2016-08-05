# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "JavaScript loader for foundation frameworks and other loadable libraries"
SECTION = "webos/frameworks"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PV = "1.1-11+git${SRCPV}"
SRCREV = "b825660290817c22e170d258b7551d5850e4c4d3"

inherit webos_ports_fork_repo
inherit webos_filesystem_paths
#inherit webos_cmake
inherit allarch

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${webos_frameworksdir}
    install -v -m 0644  ${S}/mojoloader.js ${D}${webos_frameworksdir}
}

FILES_${PN} += "${webos_frameworksdir}"
