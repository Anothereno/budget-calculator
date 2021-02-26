<template>
  <v-content fluid>
    <v-row justify="center">
      <v-col cols="3"></v-col>
      <v-col cols="6">

        <template>
          <v-card
            class="mx-auto"
            outlined
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-row align="center" justify="center">
                  <v-col>
                    <v-list-item-title class="headline mb-1">
                      Месяц: {{getMonth}}
                      <v-dialog
                        max-width="350"

                        v-model="calendarEditDialog"
                        :scrollable="false"
                      >

                        <template v-slot:activator="{ on, attrs }">
                          <v-btn
                            text
                            dark
                            color="green"
                            v-bind="attrs"
                            v-on="on"
                          >
                            <v-icon>mdi-calendar-edit</v-icon>
                          </v-btn>
                        </template>
                          <v-card outlined>
                            <v-card-text>
                              <v-row
                                align="center"
                                justify="center"
                              >
                                <MonthPicker
                                  :show-year="true"
                                  lang="ru"
                                  @change="changeDate"
                                ></MonthPicker>
                              </v-row>
                            </v-card-text>
                          </v-card>

                      </v-dialog>
                    </v-list-item-title>
                  </v-col>
                  <v-col cols="auto">
                    <v-btn text class="text-decoration-underline" large>Статистика</v-btn>
                  </v-col>
                </v-row>
                <v-spacer></v-spacer>
                <v-row
                  justify="center"
                  align="center"
                >
                  <v-col cols="auto"></v-col>
                  <v-col
                    cols="auto"
                    sm="auto"
                    class="py-5 m-7"
                  >
                    <v-btn-toggle
                      mandatory
                      color="deep-purple accent-3"
                      group
                    ><v-spacer></v-spacer>
                      <v-btn @click="changePrepaid" value="salary">
                        Зарплата за прошлый месяц
                      </v-btn>

                      <v-btn @click="changePrepaid" value="prepaid">
                        Аванс
                      </v-btn>
                    </v-btn-toggle>
                  </v-col>
                  <v-col cols="auto"></v-col>
                </v-row>
                <half-month-report
                  :is-prepaid="isPrepaid"
                  v-if="isPrepaid"
                ></half-month-report>
                <half-month-report
                  :is-prepaid="isPrepaid"
                  v-else
                ></half-month-report>
                <v-row justify="center">
                  <v-col cols="6">
                    <v-subheader>Суммарный доход за месяц:</v-subheader>
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
                    <v-subheader>Общая отложенная сумма за месяц:</v-subheader>
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
import { MonthPicker } from 'vue-month-picker'

export default {
  name: 'MonthStatistic',
  components: {
    HalfMonthReport,
    MonthPicker
  },
  data: function () {
    return {
      month: '',
      isPrepaid: false,
      calendarEditDialog: false,
      date: null
    }
  },
  beforeMount () {
    this.$budgetAPI.get('/date/month')
      .then(response => {
        this.month = response.data
      })
      .catch(e => { console.log(e) })
    this.$budgetAPI.get('/date/fullDate')
      .then(response => { console.log(response.data) })
      .catch(e => console.log(e))
  },
  methods: {
    changePrepaid () {
      this.isPrepaid = !this.isPrepaid
    },
    changeDate (date) {
      this.date = date
      console.log(this.date)
    }
  },
  computed: {
    getMonth () {
      return this.month
    }
  }
}
</script>

<style scoped>
</style>
