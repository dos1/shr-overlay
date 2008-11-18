DESCRIPTION = "Midori is a lightweight web browser."
LICENSE = "GPLv2"
DEPENDS = "webkit-gtk libsexy python"
SRC_URI = "http://goodies.xfce.org/releases/midori/midori-${PV}.tar.bz2 \
	   file://makefile.patch;patch=0 \
	   file://midori-datadir.patch;patch=0 \
	"

#do_configure() {
#	./waf configure	--datadir=${D}${datadir} --disable-docs
#
#}
#
#do_compile() {
#	./waf build
#}

#do_install() {#
#	./waf install
#}
