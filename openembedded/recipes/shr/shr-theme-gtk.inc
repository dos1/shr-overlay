RPROVIDES += "virtual/shr-theme-gtk"

#inherit update-alternatives

do_install() {
	install -d "${D}${datadir}/themes/${PN}"
	cp -r ./ "${D}${datadir}/themes/${PN}"
}



FILES_${PN} = "${datadir}/themes/${PN}"

#ALTERNATIVE_NAME = "shr-theme-gtk"
#ALTERNATIVE_LINK = "${datadir}/shr-splash/theme"
#ALTERNATIVE_PATH = "${datadir}/shr-splash/themes/${PN}"

