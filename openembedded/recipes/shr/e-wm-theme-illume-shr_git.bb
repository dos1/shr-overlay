DESCRIPTION = "illume SHR theme"
SECTION = "e/utils"
DEPENDS = "edje"
LICENSE = "MIT BSD"
PV = "1.0"
PR = "r6"

SRC_URI = "git://shr.bearstech.com/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/e-wm/${PN}"

do_compile() {
	edje_cc -id ${S}/images/. -fd ${S}/fonts/. ${S}/illume-shr.edc -o ${S}/illume-shr.edj
}

do_install() {
        install -d ${D}${datadir}/enlightenment/data/themes/
        install -m 0644 ${S}/illume-shr.edj ${D}${datadir}/enlightenment/data/themes/
}

FILES_${PN} = "${datadir}/enlightenment/data/themes/illume-shr.edj"


