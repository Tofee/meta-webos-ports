# Copyright (c) 2013 LG Electronics

PR_append = "webos1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://depends-liblttng-ust-tracepoin.patch"
