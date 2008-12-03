DESCRIPTION = "todo list manager in EFL"
HOMEPAGE = "http://xenos.altervista.org/blogs"
LICENSE = "GPL"
SECTION = "e/apps"
DEPENDS = "elementary evas"

SRC_URI = "http://xenos.altervista.org/files/projects/fido-${PV}.tar.gz" 
PV = "0.1"
PR = "r0"

inherit autotools binconfig

