<template>

    <v-data-table
        :headers="headers"
        :items="readOrderState"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReadOrderStateView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            readOrderState : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/readOrderStates'))

            temp.data._embedded.readOrderStates.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.readOrderState = temp.data._embedded.readOrderStates;
        },
        methods: {
        }
    }
</script>

