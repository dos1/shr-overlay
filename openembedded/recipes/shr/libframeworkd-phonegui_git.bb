DESCRIPTION = "Frameworkd phonegui library"
SECTION = "libs"
PV = "0.0.1"
PR = "r7"

inherit shr pkgconfig autotools

do_stage () {
        oe_libinstall -so libframeworkd-phonegui ${STAGING_LIBDIR}

        autotools_stage_includes
}
