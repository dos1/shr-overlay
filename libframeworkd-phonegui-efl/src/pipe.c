#include "pipe.h"
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <glib-2.0/glib.h>
#include <glib-2.0/glib-object.h>

PipeHandler pipe_create() {
    int r;
    int fds[2];

    r = pipe(fds);
    if(r == -1) {
        g_error("pipe() failed");
    }
    fcntl(fds[0], F_SETFL, fcntl(fds[0], F_GETFL) | O_NONBLOCK);

    PipeHandler h;
    h.input = fds[0];
    h.output = fds[1];

    return h;
}

PipeMessage* pipe_read(PipeHandler h) {
    int r;
    PipeMessage *m = malloc(sizeof(PipeMessage));
    r = read(h.input, m, sizeof(PipeMessage));
    if(r == -1)
        return -1;
    else
        return m;
}

void pipe_write(PipeHandler h, void (*callback)(int event), int event) {
    PipeMessage m;
    m.callback = callback;
    m.event = event;
    write(h.output, &m, sizeof(m));
}


