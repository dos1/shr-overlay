DESCRIPTION = "Central settings app for FSO/SHR distros"
HOMEPAGE = "http://git.freesmartphone.org"
AUTHOR = "Sebastian Spaeth (see AUTHORS)"
LICENSE  = "GPL2+"
DEPENDS = "vala elementary libeflvala"
SECTION = "x11/application"
PV = "0.0.1+r${SRCREV}"
PR = "r1"


SRC_URI = "git://github.com/spaetz/vala-settings.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_compile() {
  make
}

do_install() {
  install -d ${D}${bindir}
  install -m 0744 ${S}/settings ${D}${bindir}/

  install -d ${D}${datadir}/vala-settings/icons
  install -m 0644 ${S}/data/*.png ${D}${datadir}/vala-settings/icons
}
