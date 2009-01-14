require shr-image.inc

RDEPENDS_${PN} += "task-shr"
IMAGE_INSTALL += "task-shr"

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess_append() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}


    #Replace desktop files
    echo "Icon=pidgin.png" >> ./usr/share/applications/pidgin.desktop
    sed -i "s/^X-Icon-path.*$//g" ./usr/share/applications/vagalume.desktop

    cd $curdir
}

