<template>

    <v-data-table
        :headers="headers"
        :items="통합주문상태"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: '통합주문상태View',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            통합주문상태 : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/통합주문상태'))

            temp.data._embedded.통합주문상태.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.통합주문상태 = temp.data._embedded.통합주문상태;
        },
        methods: {
        }
    }
</script>

