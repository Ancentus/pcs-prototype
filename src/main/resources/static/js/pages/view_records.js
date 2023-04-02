$(function () {
    var table = $('#records').DataTable();
    var idx = 0;
    $('#records tbody').on('contextmenu', 'tr', function () {
        idx = table
            .row(this)
            .index();
    });
    $(document).contextmenu({
        delegate: ".dataTable td",
        menu: [
            { title: "View PCR", cmd: "view_pcr", uiIcon: "ui-icon-plus ui-icon-filter" }
        ],
        select: function (event, ui) {
            var pcrId = table.cell(idx, 0).data();

            switch (ui.cmd) {
                case "view_pcr":

                    window.location.replace(getBaseUrl() + "view_pcr?pcr_id=" + pcrId);
                    break;
            }
        },
        beforeOpen: function (event, ui) {
            var $menu = ui.menu,
                $target = ui.target,
                extraData = ui.extraData;
            ui.menu.zIndex(9999);
        }
    });
});

function getBaseUrl() {
    var re = new RegExp(/^.*\//);
    return re.exec(window.location.href);
}