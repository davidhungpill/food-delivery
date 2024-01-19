<template>

    <v-card outlined>
        <v-card-title>
            ReadOrderState # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReadOrderStateViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/readOrderStates/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

