DESCRIPTION = "Frameworkd phonegui library"
SECTION = "openmoko/pim"
PKG_TAGS_${PN} = "group::communication"
DEPENDS += " libframeworkd-glib"
PV = "0.0.1+${PR}-svnr${SRCREV}"
PR = "r3"

inherit shr pkgconfig autotools

do_stage () {
        oe_libinstall -so libframeworkd-phonegui ${STAGING_LIBDIR}

        autotools_stage_includes
}