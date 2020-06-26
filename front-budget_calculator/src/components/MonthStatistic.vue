<template>
  <v-content>
    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="6">
        <template>
          <v-card
            class="mx-auto"
            max-width="80%"
            outlined
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-row align="center" justify="center">
                  <v-col>
                    <v-list-item-title class="headline mb-1">{{getMonth}}</v-list-item-title>
                  </v-col>
                  <v-spacer></v-spacer>
                  <v-col cols="auto">
                    <v-btn text class="text-decoration-underline" large>Статистика</v-btn>
                  </v-col>
                </v-row>
                <v-spacer></v-spacer>
                <v-row>
                  <v-col cols="3"></v-col>
                  <v-col
                    cols="6"
                    sm="6"
                    class="py-5"
                  >
                    <v-btn-toggle
                      v-model="text"
                      tile
                      mandatory
                      color="deep-purple accent-3"
                      group
                    >
                      <v-btn @click="changePrepaid" value="prepaid">
                        Аванс
                      </v-btn>
                      <v-btn @click="changePrepaid" value="salary">
                        Зарплата
                      </v-btn>
                    </v-btn-toggle>
                  </v-col>
                  <v-col cols="3"></v-col>
                </v-row>
                <half-month-report v-if="isPrepaid"></half-month-report>
              </v-list-item-content>
            </v-list-item>
          </v-card>
        </template>
      </v-col>
      <v-col cols="3"></v-col>
    </v-row>
  </v-content>
</template>

<script>
import HalfMonthReport from './HalfMonthReport'
export default {
  name: 'MonthStatistic',
  components: {
    HalfMonthReport
  },
  data: function () {
    return {
      month: 'Июнь',
      isPrepaid: true
    }
  },
  methods: {
    changePrepaid () {
      this.isPrepaid = !this.isPrepaid
    }
  },
  computed: {
    getMonth () {
      return 'Месяц: ' + this.month
    }
  }
}
</script>

<style scoped>
</style>
