DESCRIPTION = "Central settings app for FSO/SHR distros"
HOMEPAGE = "http://git.freesmartphone.org"
AUTHOR = "Sebastian Spaeth (see AUTHORS)"
LICENSE  = "GPL2+"
DEPENDS = "vala elementary libeflvala"
SECTION = "x11/application"
PV = "0.0.1+r${SRCREV}"
PR = "r2"

inherit autotools

SRC_URI = "git://github.com/spaetz/vala-settings.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
