DESCRIPTION="Classic game where you control a steel ball by tilting a wooden labyrinth"
HOMEPAGE="http://mokomaze.projects.openmoko.org/"
SECTION="x11/games"
PRIORITY="optional"
LICENSE="GPLv3"
DEPENDS="libsdl-ttf libsdl-image ode"
RDEPENDS="ttf-liberation-mono"


PR="r3"
SRC_URI="http://projects.openmoko.org/frs/download.php/764/${P}.tar.gz"

inherit autotools

EXTRA_OEMAKE="FONTDIR=${datadir}/fonts/truetype"


