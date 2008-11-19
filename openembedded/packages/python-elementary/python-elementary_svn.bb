DESCRIPTION = "python elementary bindings"
LICENSE = "LGPL"
AUTHOR = "Simon Busch <morphis@gravedo.de>"
DEPENDS = "python-cython-native python-pyrex-native python-numeric edje python-evas elementary"
RDEPENDS += "python-lang python-evas"
PV = "0.1.0+svnr${SRCREV}"
PR = "r0"

inherit setuptools

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk;module=python-elementary;proto=svn;rev=${SRCREV}"
S = "${WORKDIR}/python-elementary"
