DESCRIPTION = "illume SHR theme"
SECTION = "e/utils"
DEPENDS = "edje"
LICENSE = "MIT BSD"
PV = "1.0"
PR = "r5"

SRC_URI = "\
  file://illume-shr.edc  \
  file://images"

S = "${WORKDIR}/"

do_compile() {
	edje_cc -id ${WORKDIR}/images/. -fd ${WORKDIR}/fonts/. ${WORKDIR}/illume-shr.edc -o ${WORKDIR}/illume-shr.edj
}

do_install() {
        install -d ${D}${datadir}/enlightenment/data/themes/
        install -m 0644 ${WORKDIR}/illume-shr.edj ${D}${datadir}/enlightenment/data/themes/
}

FILES_${PN} = "${datadir}/enlightenment/data/themes/illume-shr.edj"


