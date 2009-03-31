require vala.inc

inherit native
DEPENDS = "glib-2.0-native"
PR="r0"

# work around timestamp problem in tarball
do_compile_prepend() {
	touch gobject/gobject.vala.stamp
}
    
