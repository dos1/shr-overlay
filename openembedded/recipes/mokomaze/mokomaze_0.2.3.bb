DESCRIPTION="Mokomaze is the opensource implementation of the classic game where you control a steel ball by tilting a wooden labyrinth."
HOMEPAGE="http://mokomaze.projects.openmoko.org/"
SECTION="x11/games"
PRIORITY="optional"
LICENSE="GPLv3"
DEPENDS="libsdl-ttf libsdl-image"
#RDEPENDS

PR="r1"
SRC_URI="http://projects.openmoko.org/frs/download.php/764/${PN}-${PV}.tar.gz"


inherit autotools


