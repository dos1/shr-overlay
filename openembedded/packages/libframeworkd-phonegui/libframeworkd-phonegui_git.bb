DESCRIPTION = "Frameworkd phonegui library"
SECTION = "openmoko/pim"
PV = "0.0.1+${PR}-gitr${SRCREV}"
PR = "r6"

inherit shr pkgconfig autotools

do_stage () {
        oe_libinstall -so libframeworkd-phonegui ${STAGING_LIBDIR}

        autotools_stage_includes
}
