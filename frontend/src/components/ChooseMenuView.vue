<template>

    <v-data-table
        :headers="headers"
        :items="chooseMenu"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ChooseMenuView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            chooseMenu : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/chooseMenus'))

            temp.data._embedded.chooseMenus.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.chooseMenu = temp.data._embedded.chooseMenus;
        },
        methods: {
        }
    }
</script>

