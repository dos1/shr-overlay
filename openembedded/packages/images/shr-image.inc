#------------------------------------------------------
# SHR Image Recipe
#------------------------------------------------------

PV = "1.0"
PR = "r2"

IMAGE_LINGUAS = ""

RDEPENDS += "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  task-shr-minimal-base \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
  task-x11-illume \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
  task-fonts-truetype-core \
"

IMAGE_INSTALL += "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  task-shr-minimal-base \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
  task-x11-illume \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
  task-fonts-truetype-core \
"

inherit image

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess() {
    dirs=`find ${FILESDIR} -type d -printf "%P\n" | grep -v "^.$" | grep -v ".git"`
    for dir in $dirs; do
        mkdir -p ${IMAGE_ROOTFS}/$dir
    done
    files=`find ${FILESDIR} -type f -printf "%P\n" | grep -v ".git"`
    for file in $files; do
        cp -f ${FILESDIR}/$file ${IMAGE_ROOTFS}/$file
    done

    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # date/time
    date "+%m%d%H%M%Y" >./etc/timestamp
    # alias foo
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    # dns
    echo "nameserver 208.67.222.222" >>./etc/resolv.conf
    echo "nameserver 208.67.220.220" >>./etc/resolv.conf
    # nfs
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    # fix .desktop files for illume
    desktop=`find ./usr/share/applications -name "*.desktop"`
    for file in $desktop; do
        echo "Categories=Office;" >>$file
    done

    echo "Exec=vala-terminal htop" >> ./usr/share/applications/htop.desktop
    echo "Icon=settings.png" >> ./usr/share/applications/exposure.desktop

    # minimal gtk theme foo
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-theme-name = "openmoko-standard-2"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-icon-theme-name = "openmoko-standard"' >> ./etc/gtk-2.0/gtkrc
    echo '' >> ./etc/ld.so.conf
    # fix strange iconv/gconf bug
    ln -s libc.so.6 ./lib/libc.so

    # setup opkg config
    if [ -a ./etc/opkg/all-feed.conf ]; then rm ./etc/opkg/all-feed.conf; fi
    if [ -a ./etc/opkg/armv4t-feed.conf ]; then rm ./etc/opkg/armv4t-feed.conf; fi
    if [ -a ./etc/opkg/armv4-feed.conf ]; then rm ./etc/opkg/armv4-feed.conf; fi
    if [ -a ./etc/opkg/fic-gta02-feed.conf ]; then rm ./etc/opkg/fic-gta02-feed.conf; fi
    if [ -a ./etc/opkg/neo1973-feed.conf ]; then rm ./etc/opkg/neo1973-feed.conf; fi
    if [ -a ./etc/opkg/om-gta01-feed.conf ]; then rm ./etc/opkg/om-gta01-feed.conf; fi
    if [ -a ./etc/opkg/om-gta02-feed.conf ]; then rm ./etc/opkg/om-gta02-feed.conf; fi

    #frameworkd fixes
    #log to /var/log
    sed -i "s/^log_to.*/log_to = file\nlog_destination = \/var\/log\/frameworkd.log/g" ./etc/frameworkd.conf
    #deep sleep for ti_calypso
    sed -i "s/^\(modem.*=.*ti_calypso.*\)$/\1\nti_calypso_deep_sleep = never/g" ./etc/frameworkd.conf

    #font cache optimization, persistent cache
    sed -i "s/<cachedir>.*\/var\/cache\/\(.*\)<\/cachedir>/<cachedir>\/var\/local\/\1<\/cachedir>/g" ./etc/fonts/fonts.conf

    #piss of debian users with a nice gentoo-like PS1
    echo "export PS1=\"\[\033[01;32m\]\u@\h\[\033[01;34m\] \w \$\[\033[00m\] \"">> ./etc/profile

    cd $curdir
}

shr_rootfs_gta02_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    sed -i "s/^# \(.*om-gta02.*\)/\1/g" ./etc/opkg/bearstech.conf
    cd $curdir
}

shr_rootfs_gta01_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    sed -i "s/^# \(.*om-gta01.*\)/\1/g" ./etc/opkg/bearstech.conf
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += " shr_rootfs_postprocess"

ROOTFS_POSTPROCESS_COMMAND_append_om-gta02 = ";shr_rootfs_gta02_postprocess"
ROOTFS_POSTPROCESS_COMMAND_append_om-gta01 = ";shr_rootfs_gta01_postprocess"

#do_testlab() {
#	:
#}
