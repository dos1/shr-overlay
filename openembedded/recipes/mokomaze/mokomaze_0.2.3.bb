DESCRIPTION="Classic game where you control a steel ball by tilting a wooden labyrinth"
HOMEPAGE="http://mokomaze.projects.openmoko.org/"
SECTION="x11/games"
PRIORITY="optional"
LICENSE="GPLv3"
DEPENDS="libsdl-ttf libsdl-image"
RDEPENDS="ttf-liberation"

PR="r2"
SRC_URI="http://projects.openmoko.org/frs/download.php/764/${P}.tar.gz"


inherit autotools


