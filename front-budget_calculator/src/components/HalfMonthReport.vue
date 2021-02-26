<template>
  <v-container fluid>
    <v-card
      class="mx-auto"
      max-width="500"
      outlined
    >
      <v-card-title>{{receipts}}</v-card-title>
      <v-row justify="center">
        <v-col cols="6">
          <v-subheader>Планируемые траты:</v-subheader>
        </v-col>
        <v-col cols="auto">
          <v-text-field
            label="Сумма"
            value="10"
            outlined
            :readonly="true"
            prefix="₽"
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col cols="6">
          <v-subheader class="text-decoration-underline">Фактические траты:</v-subheader>
        </v-col>
        <v-col cols="auto">
          <v-text-field
            label="Сумма"
            value="10"
            outlined
            :readonly="true"
            prefix="₽"
          ></v-text-field>
        </v-col>
      </v-row>
      <v-spacer></v-spacer>
      <v-row justify="center">
        <v-col cols="6">
          <v-subheader>Откладываемые средства:</v-subheader>
        </v-col>
        <v-col cols="auto">
          <v-text-field
            label="Сумма"
            value="10"
            outlined
            :readonly="true"
            prefix="₽"
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col cols="6">
          <v-subheader>Доход:</v-subheader>
        </v-col>
        <v-col cols="auto">
          <v-text-field
            label="Сумма"
            value="10"
            outlined
            :readonly="true"
            prefix="₽"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: 'HalfMonthReport',
  data: function () {
    return {
      planSpendings: 13000,
      currentSpendings: 7000
    }
  },
  props: {
    isPrepaid: Boolean
  },
  beforeMount () {
    this.$budgetAPI.get('/money/get')
      .then(response => {
        console.log(response.data)
      })
      .catch(e => console.log(e))
  },
  computed: {
    getPlanSpendings () {
      return this.planSpendings
    },
    getCurrentSpendings () {
      return this.currentSpendings
    },
    receipts () {
      return this.isPrepaid ? 'Аванс' : 'Зарплата'
    }
  }
}
</script>

<style scoped>

</style>
